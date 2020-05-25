package com.nnfs.series

import botkop.{numsca => ns}

object Part4NnfsSingleton extends App {

  /**
   * Creates a dense layer
   *
   * Associated tutorial https://www.youtube.com/watch?v=TEWy9vZcxW4
   */

  println("Neural Networks from Scratch in Scala: Part-4 Batches, Layers, and Objects")

  val X = List(
    List(1, 2, 3, 2.5),
    List(2.0, 5.0, -1.0, 2.0),
    List(-1.5, 2.7, 3.3, -0.8)
  )
  val weights = List(
    List(0.2, 0.8, -0.5, 1.0),
    List(0.5, -0.91, 0.26, -0.5),
    List(-0.26, -0.27, 0.17, 0.87)
  )
  val biases = List(2, 3, 0.5)

  val weights2 = List(
    List(0.1, -0.14, 0.5),
    List(-0.5, 0.12, -0.33),
    List(-0.44, 0.73, -0.13)
  )
  val biases2 = List(-1, 2, -0.5)


  def dotProduct(inputs: List[List[Double]],
                 weights: List[List[Double]],
                 biases: List[Double]
                ): List[List[Double]] = {
    inputs.lazyZip(weights).map {
      case (is, _) => weights.lazyZip(biases).map {
        case (ws, bs) => is.lazyZip(ws).map(_*_).sum + bs
      }
    }
  }

  val layer1_output = dotProduct(X, weights, biases)
  val output = dotProduct(layer1_output, weights2, biases2)
  println("Output: ", output)


  // Using numsca library
  val x = ns.array(1, 2, 3, 2.5, 2.0, 5.0, -1.0, 2.0, -1.5, 2.7, 3.3, -0.8).reshape(3, 4)
  val w1 = ns.array(0.2, 0.8, -0.5, 1.0, 0.5, -0.91, 0.26, -0.5, -0.26, -0.27, 0.17, 0.87).reshape(3, 4)
  val b1 = ns.array(2, 3, 0.5).reshape(1, 3)
  val w2 = ns.array(0.1, -0.14, 0.5, -0.5, 0.12, -0.33, -0.44, 0.73, -0.13).reshape(3, 3)
  val b2 = ns.array(-1, 2, -0.5).reshape(1, 3)

  val outLayer1 =  x.dot(w1.T) + b1
  val outLayer2 =  outLayer1.dot(w2.T) + b2

  println("res: ", outLayer2)

  // Using Dense layer class
  val layer1 = new LayerDense(4,5)
  val layer2 = new LayerDense(5,2)

  val outputLayer1 = layer1.forward(x)
  val outputLayer2 = layer2.forward(outputLayer1)
  println("Output: ", outputLayer2)


}
