var canW = 1900;
var canH = 900;
var guy = [];
var count = 10;
var score = 0;
var enemyReload = 0;
var timerValue = 30;


function preload(){
  for(var i = 0; i < count; i++){
    guy[i] = new Walker("bugSprite.png", random(canW), random(40,canH - 40),random(3,9) + score,random([-1,1]));
  }
  
}

function setup() {
  createCanvas(canW, canH);
  imageMode(CENTER);
  setInterval(timeIt, 1000);
}

function mousePressed(){
  for(var i = 0; i < count; i++){
    guy[i].grab(mouseX,mouseY);
  }
}


function draw() {
  background(0,128,0);
 
  for(var i = 0; i < count; i++){
    guy[i].draw();
  }
  
  if(timerValue>0){
    
    if(enemyReload > 0){
      guy.push(new Walker("bugSprite.png", random(canW), random(40,canH - 40),random(3,9) + score/10,random([-1,1])));
      count++;
      enemyReload--;
    }
  }
  

  
  if(timerValue > 0){
    textSize(100);
    text("Score: " + score, width/4, height/8);
    textSize(50);
    text("Time Left: " + timerValue + "s",width/4 + 30,height/8 + 50);
  }
  else{
    textSize(100);
    fill('red');
    text("Score: " + score, width/4, height/8);
    textSize(50);
    text("Time Left: " + timerValue + "s",width/4 + 30,height/8 + 50);
  }
  
  
}

function Walker(imageName, x, y, speed, moving){
  this.spriteSheet = loadImage(imageName);
  this.frame = 0;
  this.x = x;
  this.y = y;
  this.moving = moving;
  this.facing = moving;
  this.speed = speed;
  this.dead = false;

  this.draw = function(){
    
    push();
    translate(this.x, this.y);
    if(this.facing<0){
      scale(-1.0,1.0);
    }

    if(timerValue == 0){
      this.stop();
    }
    if(this.moving == 0){
      image(this.spriteSheet, 0, 0, 80, 80, 160, 0, 80, 80);
    }
    else{
      if(this.frame == 0){
        image(this.spriteSheet, 0, 0, 80, 80, 0, 0, 80, 80);
      }
      if(this.frame == 1){
        image(this.spriteSheet, 0, 0, 80, 80, 80, 0, 80, 80);
      }
      
      if(frameCount % 6 == 0){
        this.frame = (this.frame + 1) % 2;
        this.x = this.x+this.moving*this.speed;
        if(this.x<30){
          this.moving = 1;
          this.facing = 1;
        }
        if(this.x>width-30){
          this.moving = -1;
          this.facing = -1;
        }
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
      if(!this.dead){
        if(timerValue > 0){
          score += 10;
          enemyReload++;
        }
        
      }
      this.dead = true;
    }

    this.grab = function(x,y){
      if(this.x-40 < x && x<this.x+40 && this.y-40 < y && y < this.y+40){
        this.stop();
        this.mouseX = x;
        this.mouseY = y;
        this.initialX = this.x;
        this.intitialY = this.y;
      }
    }
    
  }
}

function timeIt(){
  if(timerValue > 0){
    timerValue--;
  }
}

