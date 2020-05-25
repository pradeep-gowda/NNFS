package com.nnfs.series

object Part2NnfsSingleton extends App {

  /**
   * Creates a simple layer of neurons, with 4 inputs.
   *
   * Associated YT NNFS tutorial: https://www.youtube.com/watch?v=lGLto9Xd7bU
   */

  println("Neural Networks from Scratch in Scala: Part-2 Coding a layer")

  val inputs = List(1, 2, 3, 2.5)
  val weights1 = List(0.2, 0.8, -0.5, 1.0)
  val weights2 = List(0.5, -0.91, 0.26, -0.5)
  val weights3 = List(-0.26, -0.27, 0.17, 0.87)

  val bias1 = 2
  val bias2 = 3
  val bias3 = 0.5

  val output = List(
    inputs(0)*weights1(0) + inputs(1)*weights1(1) + inputs(2)*weights1(2) + inputs(3)*weights1(3) + bias1,
    inputs(0)*weights2(0) + inputs(1)*weights2(1) + inputs(2)*weights2(2) + inputs(3)*weights2(3) + bias2,
    inputs(0)*weights3(0) + inputs(1)*weights3(1) + inputs(2)*weights3(2) + inputs(3)*weights3(3) + bias3
  )

  println("Output: ", output)

  val output1 = List(
    inputs.zip(weights1).map { case (i, w) => i * w }.sum + bias1,
    inputs.zip(weights2).map { case (i, w) => i * w }.sum + bias2,
    inputs.zip(weights3).map { case (i, w) => i * w }.sum + bias3
  )
  println("Output1: ", output1)

  val output2 = List(
    inputs.lazyZip(weights1).map(_ * _).sum + bias1,
    inputs.lazyZip(weights2).map(_ * _).sum + bias2,
    inputs.lazyZip(weights3).map(_ * _).sum + bias3
  )
  println("Output2: ", output2)

}
