## The Challenge

	A team of robots must be placed by NASA to explore a terrain on Mars.
	This terrain, which is rectangular, needs to be navigated by the robots in such a way that their coupled cameras can get a complete view of the region, 
	sending those images back to Earth.

	The position of each robot is represented by the combination of Cartesian coordinates (x, y) and a letter, which can represent one of four orientations: 
	NORTH, SOUTH, EAST and WEST. To simplify navigation, the "Martian" region to be explored was subdivided into rectangular subregions.
	A valid position of a robot would be (0, 0, N), which means that the robot is positioned in the lower left corner of the terrain, facing north.
	To control each robot, NASA sends a simple string, which can contain the letters 'L', 'R' and 'M'. The letters 'L' and 'R' cause the robot to rotate on 
	its own axis 90 degrees to the left or right, respectively, without moving from its current position. The letter 'M' causes the robot to move forward.
	Assume that a robot moves to the NOR in relation to the y-axis. That is, a step to the NOR of the position (x, y), is the position (x, y + 1)
	Example: If the robot is in position (0,0, N), the command "MML" will get it to the position (0.2, W)
	This program allows NASA engineers to send commands to the Robot and know where it is. Engineers will run tests on their software to ensure that 
	it behaves the way it expects before sending the Robot to Mars.

### Requirements:

- The terrain should be started with 5x5 positions;
- The robot starts at the coordinate (0,0, N);
- It should be possible to send a command to the Robot that returns its final position;
- The Robot can not move outside the specified area;
- You should not save robot status for later reference;

### Some test scenarios:

- Movement with right turns:
- curl -s -request POST http://localhost:8080/rest/mars/MMRMMRMM
- Expected output: (2, 0, S)
- Left movement:
- Entry: curl -s -request POST  http://localhost:8080/rest/mars/MML
- Expected output: (0, 2, W)
- Repetition of requisition with left movement:
- Entry: curl -s -request POST http://localhost:8080/rest/mars/MML
- Expected output: (0, 2, W)
- Invalid command:
- curl -s --request POST  http://localhost:8080/rest/mars/AAA
- Expected output: 400 Bad Request
- Invalid position:
- curl -s -request POST  http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM
- Expected output: 400 Bad Request