/* 
Returns an element of the document if the id of the element ends
with a colon followed by shortName.
*/
function getElem(shortName) {
    var elements = document.getElementsByTagName("*");
    for (var i=0; i<elements.length; i++) {
        try {
            var fullId = elements[i].id;
            if (fullId) {
            	var subFrom = fullId.lastIndexOf(":");
            	if (subFrom) {
                    subFrom++;
                    if (shortName == fullId.substring(subFrom)) {
                        return elements[i];
                    }
            	}
            }
        } catch (e) {
        }
    }
}

/* 
move messages 
*/
function moveMessages() {
    // get the message spacer
    var gms = getElem("globalMessagesSpacer");
    // get the message component
    var gm = getElem("globalMessages");
    // re-position the message component. 
    // i.e. move it up the page to where the message spacer is
    gm.style.top = gms.offsetTop - gm.offsetTop - gm.offsetHeight - 5;
    // re-size the message spacer so that the message component doesn't hide any
    // page content
    gms.style.marginTop = gm.offsetHeight + 10;
}

/* 
A set of procedures to run on body load 
*/
function bodyLoadProcedures() {
    moveMessages();	
}

/*
Called when the state of an AJAX response changes
*/
function stateChangedCallback(a) {
    if (a == TrRequestQueue.STATE_READY) {
        moveMessages();
    }
}

// register our callback with the AJAX request queue
TrPage.getInstance().getRequestQueue().addStateChangeListener(stateChangedCallback);
