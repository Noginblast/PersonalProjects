var guy = [];
var otherGuy = [];
var count = 10;


function preload(){
  for(var i = 0; i < count; i++){
    guy[i] = new Walker("splunkyGuy.png", random(640), random(480));
    otherGuy[i] = new Walker("spelunkyYang.png", random(640), random(480));
  }
  
}

function setup() {
  createCanvas(640, 480);
  imageMode(CENTER);
}


function keyPressed(){
  if(keyCode == RIGHT_ARROW)
  {
    for(var i = 0; i <count; i++){
      guy[i].go(1);
      otherGuy[i].go(1);
    }
  }
  if(keyCode == LEFT_ARROW)
  {
    for(var i = 0; i <count; i++){
      guy[i].go(-1);
      otherGuy[i].go(-1);
    }
  }
}

function keyReleased(){
  if(keyCode == RIGHT_ARROW)
  {
    for(var i = 0; i <count; i++){
      guy[i].stop();
      otherGuy[i].stop();
    }
  }
  if(keyCode == LEFT_ARROW)
  {
    for(var i = 0; i <count; i++){
      guy[i].stop();
      otherGuy[i].stop();
    }
  }
}



function draw() {
  background(0,128,0);
 
  for(let i = 0; i < count; i++){
    guy[i].draw();
    otherGuy[i].draw();
  }
  
}

function Walker(imageName, x, y){
  this.spriteSheet = loadImage(imageName);
  this.frame = 0;
  this.x = x;
  this.y = y;
  this.moving = 0;
  this.facing = 0;

  this.draw = function(){
    push();
    translate(this.x, this.y);
    if(this.facing<0){
      scale(-1.0,1.0);
    }

    if(this.moving == 0){
      image(this.spriteSheet, 0, 0, 80, 80, 0, 0, 80, 80);
    }
    else{
      if(this.frame == 0){
        image(this.spriteSheet, 0, 0, 80, 80, 80, 0, 80, 80);
      }
      if(this.frame == 1){
        image(this.spriteSheet, 0, 0, 80, 80, 160, 0, 80, 80);
      }
      if(this.frame == 2){
        image(this.spriteSheet, 0, 0, 80, 80, 240, 0, 80, 80);
      }
      if(this.frame == 3){
        image(this.spriteSheet, 0, 0, 80, 80, 320, 0, 80, 80);
      }
      if(this.frame == 4){
        image(this.spriteSheet, 0, 0, 80, 80, 400, 0, 80, 80);
      }
      if(this.frame == 5){
        image(this.spriteSheet, 0, 0, 80, 80, 480, 0, 80, 80);
      }
      if(this.frame == 6){
        image(this.spriteSheet, 0, 0, 80, 80, 560, 0, 80, 80);
      }
      if(this.frame == 7){
        image(this.spriteSheet, 0, 0, 80, 80, 640, 0, 80, 80);
      }
      if(frameCount % 6 == 0){
        this.frame = (this.frame + 1) % 8;
        this.x = this.x+this.moving*5;
      }
    }

    pop();

    this.go = function(direction){
      this.moving = direction;
      this.facing = direction;
    }

    this.stop = function(){
      this.moving = 0;
      this.facing = 3;
    }
  }
}

