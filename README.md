# __Draw FRACTALS__ ( Mandelbrot set __&__ The Julia set )

<br/>

### Figure will be drawn in a canvas (800*800)
<br/>

### __NOTE__ : I have used __threads__. So the programe will give the figure very quickly.

<br/>

### __NOTE__ : *main class is in* __Fractal.java__ *file*
So you have to compile the programe using this ,
```bash
javac Fractal.java
```
<br/>

># *__The Mandelbrot set:__*

### If the complex number is in the Mandelbrot set then __black__ color is assigned to that number , otherwise (*if its not in the Mandelbrot set*) some another color is assigned to that complex number.

<br/>

__NOTE :__ You should set the number of iterations and the region of interest (*Range that the numbers lie*) from the command-line by passing
arguments when you are running the java file.
```bash
    java Fractal Mandelbrot -0.5 0.5 -0.1 1 1000
```
The above example means the region of interest for the image
should be from -0.5<real<0.5 and -0.1<complex<1 and for each point you need to do 1000 iterations
before deciding that it is in the set.

<br/>

__NOTE :__  *Fractal* is the name of the application.

<br/>

## Methods of giving arguments
```bash
java Fractal Mandelbrot
```
This will use ,
* -1<real<1
* -1<complex<1
* 1000 iterations

---
<br/>


```bash
java Fractal Mandelbrot -0.5 0.5 -0.1 1
```
This will use ,
* -0.5<real<0.5
* -0.1<complex<1
* 1000 iterations
---

<br/>

```bash
java Fractal Mandelbrot -0.5 0.5 -0.1 1 2000
```
This will use ,
* -0.5<real<0.5
* -0.1<complex<1
* 2000 iterations

---

<br/>
<br/>

># *__The Julia set:__*

### If the complex number is in the Julia set then __black__ color is assigned to that number , otherwise (*if its not in the Julia set*) some another color is assigned to that complex number.


<br/>

__NOTE :__ You should set the number of iterations and the specified complex number from the command-line by passing
arguments when you are running the java file.
```bash
    java Fractal Julia -0.5 0.156 1000
```
The above example means that it will plot the Julia set for C = -0.5 +
0.156i with 1000 iterations for each point.

<br/>

__NOTE :__  *Fractal* is the name of the application.

<br/>

## Methods of giving arguments
```bash
java Fractal Julia -0.5 0.156 2000
```
This will use ,
* C = -0.5 +
0.156i
* -1<real<1
* -1<complex<1
* 2000 iterations
---


<br/>

```bash
java Fractal Julia -0.5 0.156
```
This will use ,
* C = -0.5 +
0.156i
* -0.5<real<0.5
* -0.1<complex<1
* 1000 iterations
---

<br/>

> Thank you





