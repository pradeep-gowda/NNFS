package com.nnfs.series

import botkop.numsca.Tensor
import botkop.{numsca => ns}

class CreateData {

  def createData(points: Int, classes: Int) = {
    var X = ns.zeros(points * classes, 2)
    var y = ns.zeros(points * classes, 2)
    val random = scala.util.Random

    for( class_number <- 0 to classes) {
      val ix = List.range(points * class_number, points * (class_number + 1))
      val r = ns.linspace(0.0, 1, points)
      val t = ns.linspace(class_number * 4, (class_number + 1) * 4, points + random.nextInt(points) * 2)

    }

  }


}

