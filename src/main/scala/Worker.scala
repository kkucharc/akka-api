import akka.actor.{Props, Actor}
import akka.routing.RoundRobinRouter

class Worker extends Actor{

  def receive = {
    case Work(start, nrOfElements) =>
      sender ! Result(calculatePiFor(start, nrOfElements))
  }

  def calculatePiFor(start: Int, nrOfElements: Int): Double = {
    var acc = 0.0
    for (i ← start until (start + nrOfElements))
      acc += 4.0 * (1 - (i % 2) * 2) / (2 * i + 1)
    acc
  }
}
