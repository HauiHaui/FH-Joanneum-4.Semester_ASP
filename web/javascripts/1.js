/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



var xHR = XMLHttpRequest;

function showImage(pImageTypeWanted){
    
    
    xHR = new XMLHttpRequest();
    
    //xHR.setRequestHeader('Content-Type', 'text/html');
    
    xHR.open("get", "getImageName?pImageType=" + pImageTypeWanted );
    
    //DAMMN IT!!!!!!!
    //JAVASCRIPT!!!!
    //Bei updateHTML keine Klammern am Ende machen.
    xHR.onreadystatechange = updateHTML;


    xHR.send(null);


    return false;
    

    
    
}



function updateHTML(){
    
                    //alert(xHR.readyState);
                    
    if ( xHR.readyState == 4 ) {
                //alert("Hallo 2");
        if ( xHR.status > 299 || xHR.status < 200 || xHR.responseText < 2 )
            return;
        
        document.getElementById("myImage").setAttribute("src", xHR.responseText );

//alert("Inhalt: " + xHR.responseText);
        
    }
    
    
}

