var canvasW = 1900;
var canvasH = 900;
var brushColor = 'red';
 var selectionSizes = 50;



function setup() {
  createCanvas(canvasW, canvasH);
  background(255);
  colorMode(RGB);

  //Creating Selections:
 

  fill('red');
  rect(0,0,selectionSizes,selectionSizes);

  fill('orange');
  rect(0,(selectionSizes+1),selectionSizes,selectionSizes);

  fill('yellow');
  rect(0,(selectionSizes+1)*2,selectionSizes,selectionSizes);

  fill('green');
  rect(0,(selectionSizes+1)*3,selectionSizes,selectionSizes);

  fill('cyan');
  rect(0,(selectionSizes+1)*4,selectionSizes,selectionSizes);

  fill('blue');
  rect(0,(selectionSizes+1)*5,selectionSizes,selectionSizes);

  fill('magenta');
  rect(0,(selectionSizes+1)*6,selectionSizes,selectionSizes);

  fill('brown');
  rect(0,(selectionSizes+1)*7,selectionSizes,selectionSizes);

  fill('white');
  rect(0,(selectionSizes+1)*8,selectionSizes,selectionSizes);

  fill('black');
  rect(0,(selectionSizes+1)*9,selectionSizes,selectionSizes);

}

function draw() {
  

}


function mouseClicked(){
  if(mouseX <= selectionSizes && mouseY <= ((selectionSizes+1)*9) + selectionSizes){
    brushColor = get(mouseX,mouseY);
  }
    
}

function mouseDragged(){
  if(pmouseX > selectionSizes + 5 && mouseX > selectionSizes + 5){
    stroke(brushColor);
    strokeWeight(10);
    line(mouseX,mouseY,pmouseX,pmouseY);
    
  }
  if(pmouseY > (((selectionSizes+1)*9) + selectionSizes) + 5 && mouseY > (((selectionSizes+1)*9) + selectionSizes) + 5){
    stroke(brushColor);
    strokeWeight(10);
    line(mouseX,mouseY,pmouseX,pmouseY);
    
  }
  return false;

  
}

