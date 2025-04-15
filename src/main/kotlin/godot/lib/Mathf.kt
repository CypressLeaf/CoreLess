package godot.lib

import godot.core.Vector2
import kotlin.math.cos
import kotlin.math.sin

object Mathf {
    fun vec2D(angle: Double, speed: Double): Vector2{
        val vec2D = Vector2.RIGHT
        return vec2D.rotated(angle) * speed
    }
    fun newVec(长度: Number,旋转: Double): Vector2 {
        var vec = Vector2.RIGHT// 向右→ 的向量
        return vec.rotated(旋转) * (长度 as Double)
    }

}
