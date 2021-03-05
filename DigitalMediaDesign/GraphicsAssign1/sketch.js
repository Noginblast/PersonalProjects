
var canvasW = 1900;
var canvasH = 900;


function setup() {
  createCanvas(canvasW, canvasH);
}

function draw() {
  background(220);
  


  //Creating First Project Image:

    //Creating Base of Image
    var base1W = 400;
    var base1H = 200;
    fill(0, 255, 0);
    noStroke();
    rect(width/4 - base1W/2, height/4 - base1H/2, base1W, base1H);

    //Creating Circle
    stroke('black');
    strokeWeight(2);
    fill(255, 255, 255);
    circle(width/4 - base1W/4, height/4, base1H - 20);

    //Creating Square
    rect(width/4 + base1W/4 - ((base1H - 20)/2), height/4 - ((base1H - 20)/2), base1H - 20, base1H - 20);





  //Creating Second Project Image:

    //Creating Base of Image
    var base2HW = 300;
    var circleConstraint = 200;

    noStroke();
    rect((width * 3 / 4) - base2HW/2, height/4 - base2HW/2, base2HW, base2HW);



    //Creating Circles
    fill(255,0,0,100);
    circle((width * 3 / 4), height/4 - (circleConstraint*2/3)/4, circleConstraint/3 * 2);

    fill(0,255,0,100);
    circle((width * 3 / 4) + (circleConstraint*2/3)/4, height/4 + (circleConstraint/6)*2/3, circleConstraint/3 * 2);

    fill(0,0,255,100);
    circle((width * 3 / 4) - (circleConstraint*2/3)/4, height/4 + (circleConstraint/6)*2/3, circleConstraint/3 * 2);

  



  //Creating Third Project Image:

    //Creating Base of Image
    var base3W = 400;
    var base3H = 200;

    noStroke();
    fill('black');
    rect(width/4 - base3W/2, height*3/4 - base3H/2, base3W, base3H);


    //Creating PacMan
    fill('yellow');
    arc(width/4 - base3W/4, height*3/4, base3H - 20, base3H - 20, PI + QUARTER_PI, PI - QUARTER_PI, PIE);


    //Creating Ghost:
      
      //Creating Ghost Body

      fill(255,0,0);
      circle(width/4 + base3W/4, height*3/4, base3H - 20);
      rect(width/4 + base3W/4 - (base3H - 20)/2, height*3/4, base3H - 20, (base3H - 20)/2);

      //Creating Ghost Eyes

      fill(255,255,255);
      circle(width/4 + base3W/4 - (base3H - 20)/4, height*3/4, (base3H - 20)/3);
      circle(width/4 + base3W/4 + (base3H - 20)/4, height*3/4, (base3H - 20)/3);

      fill(0,0,255);
      circle(width/4 + base3W/4 - (base3H - 20)/4, height*3/4, (base3H - 20)/6);
      circle(width/4 + base3W/4 + (base3H - 20)/4, height*3/4, (base3H - 20)/6);




  
  //Creating Fourth Project Image:

    //Creating Base
    var base4HW = 300;

    fill(0,0,150);
    rect((width * 3 / 4) - base4HW/2, height*3/4 - base4HW/2, base4HW, base4HW);


    //Creating Circle

    stroke('white');
    strokeWeight(4);
    fill('green');
    circle(width*3/4, height*3/4, base4HW/2);
    

    //Creating Star
    var angle = TWO_PI / 5;
    var halfAngle = angle / 2.0;

    fill('red');
    beginShape();
    for (var a = PI*18/180; a < TWO_PI; a += angle) {
      var sx = width*3/4 + cos(a) * 30;
      var sy = height*3/4 + sin(a) * 30;
      vertex(sx, sy);
      sx = width*3/4 + cos(a + halfAngle) * 70;
      sy = height*3/4 + sin(a + halfAngle) * 70;
      vertex(sx, sy);
    }
    endShape(CLOSE);
    

} 


