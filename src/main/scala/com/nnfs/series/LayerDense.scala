package com.nnfs.series

import botkop.numsca.Tensor
import botkop.{numsca => ns}

class LayerDense(nInputs: Int, nNeurons: Int) {
  val weights: Tensor = 0.10 * ns.randn(nInputs, nNeurons)
  val biases: Tensor = ns.zeros(1, nNeurons)

  def forward(inputs: Tensor): Tensor = {
    ns.dot(inputs, weights) + biases
  }
}
