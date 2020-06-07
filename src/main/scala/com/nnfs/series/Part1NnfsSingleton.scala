package com.nnfs.series

object Part1NnfsSingleton extends App {

  /**
   * Creates a basic neuron with 3 inputs
   *
   * Associated YT NNFS tutorial: https://www.youtube.com/watch?v=Wo5dMEP_BbI
   */

  println("Neural Networks from Scratch in Scala: Part-1 Intro and Neuron Code")

  val inputs = List(1.2, 5.1, 2.1)
  val weights = List(3.1, 2.1, 8.7)
  val bias = 3

  val output = inputs(0)*weights(0) + inputs(1)*weights(1) + inputs(2)*weights(2) + bias
  println("Output: \n" + output)

  // zip creates tuples
  // zip followed by map will result in two separate transformations due to strictness
  val output1 = inputs.zip(weights).map { case (i, w) => i * w }.sum + bias
  println("Output1: \n" + output1)

  // lazyZip is faster than zip
  // lazyZip followed by map will result in a single transformation executed in one go due to laziness.
  val output2 = ((inputs lazyZip weights) map { case (i, w) => i * w }).sum + bias
  val output3 = inputs.lazyZip(weights).map { case (i, w) => i * w }.sum + bias
  val output4 = inputs.lazyZip(weights).map(_ * _).sum + bias
  println("Output2: \n" + output2)
  println("Output3: \n" + output3)
  println("Output4: \n" + output4)

}
