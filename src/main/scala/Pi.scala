import akka.actor._
import akka.routing.RoundRobinRouter
import akka.util.Duration
import akka.util.duration._

class Pi {
  sealed trait PiMessage
  case object Calculate extends PiMessage
  case class Work(start: Int, nrOfElements: Int) extends PiMessage
  case class Result(value: Double) extends PiMessage
  case class PiApproximation(pi: Double, duration: Duration)
}
