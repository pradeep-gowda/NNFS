package com.nnfs.series

import botkop.numsca.Tensor
import botkop.{numsca => ns}

class Activation {

  def ReLu(inputs: Tensor): Tensor = {
    ns.maximum(inputs, 0)
  }

}
