
package com.butterfill.opb.jsedemo;

import com.butterfill.opb.jsedemo.objectgraph.data.Address;
import com.butterfill.opb.jsedemo.objectgraph.data.Cities;
import com.butterfill.opb.jsedemo.objectgraph.data.City;
import com.butterfill.opb.jsedemo.objectgraph.data.CityValueObject;
import com.butterfill.opb.jsedemo.objectgraph.data.Person;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.util.OpbValueObjectHelper;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Shows how Opb objects can be converted to and from JSON (http://www.json.org/).
 * <br/>
 * <b>Please refer to package.html for DB set-up details.</b>
 * <b>To run this demo;</b>
 * <ul>
 * <li>Run the main method of this class.</li>
 * </ul>
 *
 */
public class JsonDemoMain {

    /**
     * Converting Opb objects to JSON is a 2 step process;
     * - convert Opb objects to value objects (using OpbValueObjectHelper)
     * - convert value objects to JSON
     *
     * Converting JSON to Opb objects is the same 2 steps in reverse.
     *
     * Value objects are used as intermediate data transfer objects - making it easy to work with
     * JSON processing libraries.
     * This example uses http://wiki.fasterxml.com/JacksonHome. See also dependency in pom.xml.
     *
     * @param args
     *   Is ignored.
     */
    public static void main(String[] args) throws Exception {
        // create the spring context
        final AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // register the shutdown hook so that the context will call destroy methods
        context.registerShutdownHook();

        // set-up the test data
        setUpData(context);

        // get a new session
        final OpbSession session = (OpbSession) context.getBean("opbSession");

        // create a value object helper
        final OpbValueObjectHelper valueObjectHelper = new OpbValueObjectHelper(session);

        // create the JSON mapper
        final ObjectMapper mapper = new ObjectMapper();

        System.out.println("*** Start of part 1 ***");

        // create a new cities instance - that we can use to list cities
        // see cities.getFiltered() below
        Cities cities = session.getDataObjectSource().newInstance(Cities.class);

        // list cities, convert to value objects and then write to JSON
        String citiesJson = mapper.writeValueAsString(
                valueObjectHelper.toValueObjectList(cities.getFiltered()));

        // print the JSON
        System.out.println("citiesJson;\n" + citiesJson);

        // read the JSON back into a list of value objects
        List<CityValueObject> citiesValueObjects =
                mapper.readValue(citiesJson, new TypeReference<List<CityValueObject>>(){});

        // print the value objects
//        System.out.println("citiesValueObjects;\n" + OpbToStringHelper.toStringFull(citiesValueObjects));

        // convert the value objects back to Opb objects
        List<City> citiesOpb = valueObjectHelper.toOpbObjectList(City.class, citiesValueObjects);

        // print the Opb objects
//        System.out.println("citiesOpb;\n" + OpbToStringHelper.toStringFull(citiesOpb));

        // make a DB update to show that the Opb objects we have now are fully functional
        City city = citiesOpb.get(0);
        city.setCityName("New city name");
        System.out.println(
                "Updating city " + city.getCityId()
                + ". changing name from Bombay to New city name");
        city.upd();

        System.out.println("*** End of part 1 ***");

        // Note: Spring will release the connection held by our session via the destroy-method

    }

    /**
     * Sets up the demo data.
     * @param context
     *   A spring context - from which we can get an Opb session.
     */
    private static void setUpData(AbstractApplicationContext context) {
        // get a new session - for data set-up
        final OpbSession session = (OpbSession) context.getBean("opbSession");

        Cities cities = session.getDataObjectSource().newInstance(Cities.class);

        // delete all data - this works as foreign keys are set to cascade on delete
        for (City city : cities.getFiltered()) {
            city.del();
        }

        City newCity = session.getDataObjectSource().newInstance(City.class);
        Address newAddress = session.getDataObjectSource().newInstance(Address.class);
        Person newPerson = session.getDataObjectSource().newInstance(Person.class);

        // create some cities
        newCity.setCityName("Bombay");
        newCity.ins();

        newCity.setCityName("Glasgow");
        newCity.ins();

        newCity.setCityName("Berlin");
        newCity.ins();

        // create some addresses (and people associated with the addresses)
        newAddress.setCityId(cities.getCityId("Bombay"));
        newAddress.setLine1("1 Long Street");
        newAddress.ins();

        newPerson.setAddressId(newAddress.getAddressId());
        newPerson.setFirstName("Shah");
        newPerson.setLastName("Jahan");
        newPerson.ins();

        newAddress.setCityId(cities.getCityId("Glasgow"));
        newAddress.setLine1("2 High Street");
        newAddress.setLine2("Near the river Clyde");
        newAddress.ins();

        for (int i = 10; i < 15; i++) {
            newAddress.setCityId(cities.getCityId("Berlin"));
            newAddress.setLine1(i + " Wide Av");
            newAddress.ins();
            // create some people who will use this new address
            for (int j = i; j < 15; j++) {
                newPerson.setAddressId(newAddress.getAddressId());
                newPerson.setFirstName("Charlie " + j);
                newPerson.setLastName("Last " + i + "." + j);
                newPerson.ins();
            }

        }

        // Note: Spring will release the connection held by our session via the destroy-method

    }

}
