package basics
import swiftvis2.plotting._
import swiftvis2.plotting.styles.ScatterStyle
import swiftvis2.plotting.renderer.SwingRenderer

case class TempRow(day:Int, doy: Int, month: Int, year: Int, precip: Double, tave: Double, tmax: Double, tmin: Double)

object SATemps{
	def parseLine(line:String): TempRow = {
		val p = line.split(",")
		TempRow(p(0).toInt, p(1).toInt, p(2).toInt, p(4).toInt, p(5).toDouble, p(6).toDouble, p(7).toDouble, p(8).toDouble)
	} 

	def main(args: Array[String]): Unit ={
		val source = scala.io.Source.fromFile("/users/mlewis/CSCI3395-F19/InClassBD/data/SanAntonioTemps.csv")
		val lines = source.getLines()
		val data = lines.drop(2).map(parseLine).toArray
		//data.take(5).foreach(println)

		val hotDay1 = data.maxBy(_.tmax)
		//val hotDay2 = data.reduce((d1,d2) => if(d1.maxT > d2.maxT) d1 else d2)
		//println("Day with the highest temp: "+hotDay1)
		//println(hotDay2)
		val wetDay = data.maxBy(_.precip)
		//println("Day with most rain: "+wetDay)
		val daysWithLotsOfRain = data.filter(_.precip >= 1.0)
		//println("Fraction of days with more than 1\" of rain: "+(daysWithLotsOfRain.size.toDouble)/(data.size))

		val rainyDaysAvgT = (for(day <- daysWithLotsOfRain) yield day.tmax).sum/daysWithLotsOfRain.size
		//println("Avg temp of the rainy days: "+rainyDaysAvgT)

		val rainyDaysAvgT2 = daysWithLotsOfRain.foldLeft(0.0)(_ + _.tmax)/daysWithLotsOfRain.size
		//println("2.0: "+rainyDaysAvgT2)

		//avg high temp by month
		val avgHighTempsByMonth = data.groupBy(_.month).mapValues((rows) => rows.map(_.tmax).sum / rows.length)
		//for((k, v) <- avgHighTempsByMonth) println("For month "+k+" the avg high temp was: "+avgHighTempsByMonth(k))
		//avgHighTempsByMonth.toSeq.sortBy(_._1).foreach(println)

		//avg rain by month
		val avgRainByMonth = data.groupBy(_.month).mapValues(_.map(_.precip))
		//for((k, v) <- avgRainByMonth) println("For month "+k+" the avg rain was: "+(avgRainByMonth(k).sum/avgRainByMonth(k).size))

		//median rain by month
		val medRainByMonth = data.groupBy(_.month).mapValues(m => m.sortBy(_.precip).apply(m.length/2))
		//medRainByMonth.toSeq.sortBy(_._1).foreach(println)


		val cg = ColorGradient(1946.0 -> RedARGB, 1975.0 -> BlueARGB, 2014.0 -> GreenARGB)
		val sizes = data.map(_.precip*2 +2)
		val tempByDayPlot = Plot.simple(ScatterStyle(data.map(_.doy), data.map(_.tave), symbolWidth = sizes, symbolHeight = sizes, colors = cg(data.map(_.year))),
		"SA Temps", "Day of Year", "Temp")
		SwingRenderer(tempByDayPlot, 800, 800, true)



		
	}
	

}