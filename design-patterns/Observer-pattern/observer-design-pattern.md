Observer design pattern:

Problem:- 
When a central object changes its state, to notify the objects that subscribe to this central object, the central object needs to notify each of them seperately, which is like a tightly coupled system which cant be scaled 

Why this pattern exists:
To eliminate the tight coupling with the central object and all the objects that are connected to this and want to react to the state changes of the central object, the main thing is that we dont have to change anything in the central object code modify the subscribers or notify themn when new subscribers get added or removed 


Real world example:
there is a stock price service - its value keeps changing 
now the subscribers of this service are dashboard1, dashboard2, alert-service 
now on the change of stock price service state, how do we notify all of its subscribers of the price changes 

Class Diagram
- in the readme.md file 

Advantages:
- Removes the tightly coupled components 
- Can scale to any number of subscribers without causing any load on the central object
- the subject and the observers are loosely coupled


Disadvantages:
- A mistake in one observer can affect the whole system if the observer throws an error.
- Harder to debug

When not to use it:
- when there are just one or two dependents and this is not gonna change anytime and its fixed, then no use of using this pattern 
- when you need strong control over the sequence and timing of updates 
- when we donot need dynamic subscriptions

