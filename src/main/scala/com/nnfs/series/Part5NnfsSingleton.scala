package com.nnfs.series

import botkop.numsca.Tensor
import botkop.{numsca => ns}

object Part5NnfsSingleton extends App {

  // Using numsca library
  val x: Tensor = ns.array(1, 2, 3, 2.5, 2.0, 5.0, -1.0, 2.0, -1.5, 2.7, 3.3, -0.8).reshape(3, 4)

  // Using Dense layer class
  val layer1 = new LayerDense(4,5)
  // Using Activation class
  val activation1 = new Activation

  val outputLayer1 = layer1.forward(x)
  val activationOutputLayer1 = activation1.ReLu(outputLayer1)

  println("Layer Output: \n" + outputLayer1)
  println("\n")
  print("Layer Output with Relu Activation: \n" + activationOutputLayer1)
}
