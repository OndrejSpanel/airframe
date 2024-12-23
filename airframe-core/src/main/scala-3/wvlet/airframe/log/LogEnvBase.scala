package wvlet.airframe.log

import java.io.PrintStream

/**
  */
private[log] trait LogEnvBase:
  def initLogManager(): Unit = {
    // do nothing by default
  }

  def isScalaJS: Boolean
  def defaultLogLevel: LogLevel
  def defaultHandler: java.util.logging.Handler
  def defaultConsoleOutput: PrintStream

  /**
    * @param cl
    * @return
    */
  def getLoggerName(cl: Class[?]): String

  def scheduleLogLevelScan: Unit
  def stopScheduledLogLevelScan: Unit

  /**
    * Scan the default log level file only once. To periodically scan, use scheduleLogLevelScan
    */
  def scanLogLevels: Unit

  /**
    * Scan the specified log level file
    *
    * @param loglevelFileCandidates
    */
  def scanLogLevels(loglevelFileCandidates: Seq[String]): Unit

  def registerJMX: Unit

  /**
    */
  def unregisterJMX: Unit
