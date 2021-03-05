let multiplayer;

function setup() {
  createCanvas(windowWidth, windowHeight);
  background('cyan');
  

  delay = new Tone.FeedbackDelay(0.5,1).toDestination();


  multiplayer = new Tone.Players({horn: 'horn.wav', softAmbience: 'soft-ambience.wav', bearGroan: 'bear-groan.wav', piano: 'goodbye-am.wav'}).toDestination();


  button1 = createButton('Play Horn');
  button1.position(width/4, 40);
  button1.mousePressed(() => multiplayer.player('horn').start());

  button2 = createButton('Play Soft Ambience');
  button2.position(width/4, 100);
  button2.mousePressed(() => multiplayer.player('softAmbience').start());

  button3 = createButton('Play Bear Groan');
  button3.position(width/4, 160);
  button3.mousePressed(() => multiplayer.player('bearGroan').start());

  button4 = createButton('Play Piano Theme');
  button4.position(width/4, 220);
  button4.mousePressed(() => multiplayer.player('piano').start());

  button5 = createButton('Stop Sounds');
  button5.position(width/4, 280);
  button5.mousePressed(() => multiplayer.stopAll());

  mixer = createSlider(0, 1, 1, 0);
  mixer.style('width', "200px");
  mixer.position(width/4, 340);

  text("Delay", width/4 + 20, 370);
  text
  
  
}

function draw() {
  delay.wet.value = mixer.value();

  
}

