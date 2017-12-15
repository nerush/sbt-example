import org.scalameter.api._
import MacroConcat._

object InterpolationBenchmark extends Bench.LocalTime {
  val sizes = Gen.range("size")(300000, 1500000, 300000)

  performance of "Interpolation" config (exec.benchRuns -> 1000000) in {
    measure method "s" in {
      using(sizes) in { r =>
        s"a $r b $r c $r d $r a $r b $r c $r d $r a $r b $r c $r d $r"
      }
    }
    measure method "so" in {
      using(sizes) in { r =>
        so"a $r b $r c $r d $r a $r b $r c $r d $r a $r b $r c $r d $r"
      }
    }
    measure method "sfi" in {
      using(sizes) in { r =>
        sfi"a $r b $r c $r d $r a $r b $r c $r d $r a $r b $r c $r d $r"
      }
    }
  }
}
