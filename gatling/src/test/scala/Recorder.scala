import io.gatling.recorder.GatlingRecorder
import io.gatling.recorder.config.RecorderPropertiesBuilder

object Recorder extends App {

	val props = new RecorderPropertiesBuilder
	props.simulationOutputFolder(IDEPathHelper.recorderOutputDirectory.toString)
	props.simulationPackage("no.bekk.javazone2013")
	props.bodiesFolder(IDEPathHelper.bodiesDirectory.toString)

	GatlingRecorder.fromMap(props.build, Some(IDEPathHelper.recorderConfigFile))
}
