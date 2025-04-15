package godot

import godot.annotation.Export
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.annotation.RegisterProperty
import godot.api.Node
import godot.global.GD

@RegisterClass
class Main : Node() {

	@Export
	@RegisterProperty
	var helloString =  "Godot"

	@RegisterFunction
	override fun _enterTree() {
		GD.print("Are you ready kid?")
	}
	@RegisterFunction
	override fun _ready() {
		GD.print("I'am ready!")
	}
}

fun main() {
	GD.print("Hello World")
}