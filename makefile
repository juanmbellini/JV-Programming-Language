run:
	ant clean
	ant run
	java -cp examples/java/gen/ Hello_world
hello:
	java -jar ./dist/Compiler.jar examples/jv/hello_world.jv
