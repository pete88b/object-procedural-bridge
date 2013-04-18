
package com.butterfill.opb.jsedemo;

import com.butterfill.opb.jsedemo.objectgraph.data.Address;
import com.butterfill.opb.jsedemo.objectgraph.data.Cities;
import com.butterfill.opb.jsedemo.objectgraph.data.City;
import com.butterfill.opb.jsedemo.objectgraph.data.People;
import com.butterfill.opb.jsedemo.objectgraph.data.Person;
import com.butterfill.opb.session.OpbSession;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Shows how PL/SQL functions can be used to create an object graph.
 * <br/>
 * <b>Please refer to package.html for DB set-up details.</b>
 * <b>To run this demo;</b>
 * <ul>
 * <li>Run the main method of this class.</li>
 * </ul>
 *
 */
public class ObjectGraphDemoMain {

    /**
     * In the DB, we have a person, which has an address, which has a city.
     * <br>
     * Part 1 shows how we can get the addresses of a city and then the people of an address.
     * <br>
     * Part 2 shows how we can get the same data using a single DB call.
     * <br>
     * Part 3 shows a couple of alternatives to help you decide between walking the object
     * graph and adding fields to an object (by adding Opb fields to the PL/SQL package).
     *
     * @param args
     *   Is ignored.
     */
    public static void main(String[] args) {
        // create the spring context
        final AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // register the shutdown hook so that the context will call destroy methods
        context.registerShutdownHook();

        // set-up the test data
        setUpData(context);

        // get a new session
        final OpbSession session = (OpbSession) context.getBean("opbSession");

        System.out.println("*** Start of part 1 ***");

        // find all people in the city of Berlin via object graph
        Cities cities = session.getDataObjectSource().newInstance(Cities.class);
        City berlin = cities.getFiltered("Berlin").get(0);
        for (Address address : berlin.getAddresses()) {
            for (Person person : address.getPeople()) {
                System.out.println(
                        person.getFirstName() + " " + person.getLastName()
                        + " lives at " + address.getLine1());
            }
        }

        System.out.println("*** End of part 1 ***");
        System.out.println("*** Start of part 2 ***");

        // or you could use a search function that has been added to the people PL/SQL package
        People people = session.getDataObjectSource().newInstance(People.class);
        for (Person person : people.getFiltered(null, null, null, "berlin")) {
            System.out.println(
                    person.getFirstName() + " " + person.getLastName());
        }

        System.out.println("*** End of part 2 ***");
        System.out.println("*** Start of part 3 ***");

        // so if we have a person, how do we get the address?
        for (Person person : people.getFiltered(null, null, null, "bombay")) {
            System.out.println(
                    person.getFirstName() + " " + person.getLastName());
            // we could add a function to the person PL/SQL package to return the address object
            System.out.println("Address via object graph; " + person.getAddress().get(0).getLine1());
            // or we could add Opb fields to the person
            System.out.println("Address via field; " + person.getAddressLabel());
            // Note: we also added the city field
            System.out.println("City via field; " + person.getCityLabel());
        }

        System.out.println("*** End of part 3 ***");

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
