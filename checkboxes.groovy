@Grab(group='org.gebish', module='geb-core', version='0.9.1')
@Grab(group='org.seleniumhq.selenium', module='selenium-chrome-driver', version='2.35.0')
@Grab(group='org.seleniumhq.selenium', module='selenium-support', version='2.35.0')

import geb.Browser

Browser.drive {

    go "file://${new File(getClass().protectionDomain.codeSource.location.path).parent}/page.html"

    // check checkbox state (by name, index and id)
    assert $('input', name: 'checkbox1').value() == false // not checked as it returns false
    assert checkbox2().value() == 'value2' // checked as it returned something other than false
    assert $('input', 1).value() != false // checked as it returned something other than false
    assert $('#second-checkbox').value() == 'value2' // checked as is returned sometihing other than false

    // check or uncheck a checkbox
    $('input', name: 'checkbox3').value(true) // was not checked, now it is
    $('input', name: 'checkbox4').value(false) // was checked, now it is not

    // iterate checkboxes
    $('input[type=checkbox]').each {
        println "checkbox ${it.@name} has value of '${it.value()}'"
    }
}
