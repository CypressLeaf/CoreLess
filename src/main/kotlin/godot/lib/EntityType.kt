package godot.lib

import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.annotation.RegisterProperty
import godot.api.*
import godot.core.Vector2
import kotlin.math.PI

@RegisterClass
class EntityType : Node2D() {
    @RegisterProperty
    var maxSpeed: Double = 45.0
    @RegisterProperty
    var angle: Double = PI
    @RegisterProperty
    var rotateSpeed: Double = 15.0
    @RegisterProperty
    var acceleration: Double = 1.5
    @RegisterProperty
    var deceleration: Double = 1.2

    //内部状态：
    private var speed: Vector2 = Vector2.ZERO//当前速度
    private var moving: Double = 0.0

    @RegisterFunction
    override fun _ready() {/*
        val collisionVolume = CollisionShape2D().also {
            it.shape = RectangleShape2D().apply {
                it.position = Vector2(0,0)
            }
        }
        this.addChild(collisionVolume)
        val sprite = Sprite2D().also {
            it.texture = ResourceLoader.load("Entities/Plane.png") as Texture2D
            it.position = Vector2(0,0)
            it.centered = true
        }
        this.addChild(sprite)*/
    }

    @RegisterFunction
    override fun _physicsProcess(delta: Double) {
        if (Input.isActionPressed(KeyBoard.W)){
            speed += Mathf.vec2D(rotation.toDouble() - PI/2,maxSpeed)
        }
        if (Input.isActionPressed(KeyBoard.S)){
            speed += Mathf.vec2D(rotation.toDouble() + PI/2, maxSpeed)
        }
        if (Input.isActionPressed(KeyBoard.A)){
            speed += Mathf.vec2D(rotation.toDouble(), -maxSpeed)
        }
        if (Input.isActionPressed(KeyBoard.D)){
            speed += Mathf.vec2D(rotation.toDouble(), maxSpeed)
        }
        //speed = speed.normalized()
        val rotateInput = Input.getActionStrength(KeyBoard.Q) - Input.getActionStrength(KeyBoard.E)
        rotation += (-rotateInput * rotateSpeed * delta).toFloat()
}

    @RegisterFunction
    override fun _process(delta: Double) {
        position = speed * delta
    }
}