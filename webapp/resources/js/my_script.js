/**
 * Created with IntelliJ IDEA.
 * User: MAK
 * Date: 12/9/14
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */

function clearErrMsg(){
     $('.errMsgLabel').html("");
}


/*Making Progress Bar Section START*/
function waitPlease(msg) {
    $('#progressModalTitle').html(msg);
    $('#seProgressModal').modal("show");
}

var modalClose = function(){
    $('#seProgressModal').modal("hide");
};

function waitingEnd(time) {
    setTimeout(modalClose, time);
}
/*Making Progress Bar Section END*/



function checkValidity(){
    var date = document.getElementById("paymentDate").value.split("-");
    if(date[0].length == 4 && date.size() == 3){
        alert("1");
        return true;
    }else {
        return false;
        alert("2");
    }
    alert("3");

}


/*List Box functions*/
function mak_listBox_move(listID, direction) {
    var listBox = document.getElementById(listID);
    var selIndex = listBox.selectedIndex;
    if (-1 == selIndex) {
        alert("Please select an option to move.");
        return;
    }
    var increment = -1;
    if (direction == 'moveUp')
        increment = -1;
    else
        increment = 1;
    if ((selIndex + increment) < 0 || (selIndex + increment) > (listBox.options.length - 1)) {
        return;
    }
    var selValue = listBox.options[selIndex].value;
    var selText = listBox.options[selIndex].text;
    listBox.options[selIndex].value = listBox.options[selIndex + increment].value;
    listBox.options[selIndex].text = listBox.options[selIndex + increment].text;
    listBox.options[selIndex + increment].value = selValue;
    listBox.options[selIndex + increment].text = selText;
    listBox.selectedIndex = selIndex + increment;
}
function mak_listBox_moveAcross(sourceId, destinationId, quantity) {
    if(quantity == 'all'){
        mak_listBox_selectAll(sourceId, true);
    }
    var source = document.getElementById(sourceId);
    var destination = document.getElementById(destinationId);
    for (var count = 0; count < source.options.length; count++) {
        if (source.options[count].selected == true) {
            var option = source.options[count];
            var newOption = document.createElement("option");
            newOption.value = option.value;
            newOption.text = option.text;
            newOption.selected = true;
            try {
                destination.add(newOption, null);
                source.remove(count, null);
            } catch (error) {
                destination.add(newOption);
                source.remove(count);
            }
            count--;
        }
    }
}
function mak_listBox_selectAll(listID, isSelect) {
    var listBox = document.getElementById(listID);
    for (var count = 0; count < listBox.options.length; count++) {
        listBox.options[count].selected = isSelect;
    }
}



