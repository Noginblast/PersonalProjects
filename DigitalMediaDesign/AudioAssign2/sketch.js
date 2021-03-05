

//MAY HAVE TO SAVE FILE DURING FIRST RUN TO OBTAIN SOUND

var osc; var oscillate; var oscilNoise;
var ampEnvilope; var ampEnvilopeNoise;
var filter;
var lfo; var lfo2;


function setup() {
	createCanvas(windowWidth,windowHeight);
	
	lfo = new Tone.LFO(10, -70, 0).start();
	lfo2 = new Tone.LFO(10, -100, 0).start();
	
	oscilNoise = new Tone.Noise().start();
	filter = new Tone.Filter(200, "lowpass");
	
	oscillate = new Tone.Oscillator(440, "sine").start();
	osc = new Tone.Oscillator(660, "sawtooth6").start();
	osc.volume.value = -20;
	
	
	ampEnvilope = new Tone.AmplitudeEnvelope({
		"attack": 0.1,
		"decay": 0.2,
		"sustain": 1.0,
		"release": 0.8
	}).toDestination();

	ampEnvilopeNoise = new Tone.AmplitudeEnvelope({
		"attack" : 0.1,
		"decay" : 0.1,
		"sustain" : 1.0,
		"release" : 0.2
	}).toDestination();
	
	oscillate.connect(ampEnvilope);	
	osc.connect(ampEnvilope);
	lfo2.connect(osc.frequency);

	lfo.connect(oscilNoise.volume);
	oscilNoise.connect(filter);
	filter.connect(ampEnvilopeNoise);
}

function keyPressed() {
	if (keyCode == 65){
		oscillate.frequency.value = 'A4';
		ampEnvilope.triggerAttackRelease(0.5);
	}
	if (keyCode == 83) {
		oscillate.frequency.value = 'B4';
		ampEnvilope.triggerAttackRelease(0.5);
	}
	if (keyCode == 68) {
		oscillate.frequency.value = 'C4';
		ampEnvilope.triggerAttackRelease(0.5);
	}
	if (keyCode == 70) {
		oscillate.frequency.value = 'D4';
		ampEnvilope.triggerAttackRelease(0.5);
	}
	if(keyCode == 71){
		ampEnvilopeNoise.triggerAttackRelease(0.5);
	}
}

function draw() {
  
  background('purple');
  fill('white');
  textSize(40);
  text("PRESS KEYS                                TO PLAY TUNES", windowWidth/4, windowHeight/2);
  fill('Black');
  text("                         A, S, D, F, AND G              ", windowWidth/4, windowHeight/2);

}