package com.nnfs.series

object Part3NnfsSingleton extends App {

  /**
   * Creates a simple neuron layer using dot product.
   *
   * Associated tutorial https://www.youtube.com/watch?v=tMrbN67U9d4
   */

  println("Neural Networks from Scratch in Scala: Part-3 The Dot Product")

  val inputs = List(1, 2, 3, 2.5)
  val weights = List(
    List(0.2, 0.8, -0.5, 1.0),
    List(0.5, -0.91, 0.26, -0.5),
    List(-0.26, -0.27, 0.17, 0.87)
  )
  val biases = List(2, 3, 0.5)

  val output = weights.lazyZip(biases).map {
    case (w, b) => inputs.lazyZip(w).map(_ * _).sum + b
  }

  println("Dot Product Output: ", output)

}
