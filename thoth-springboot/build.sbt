import sbt.Keys.organization
import Dependencies._

organization := "fr.maif"

name := "thoth-springboot"

val springbootVersion = "2.2.2.RELEASE"

libraryDependencies ++= Seq(
  "io.vavr"                  % "vavr"                                % vavrVersion,
  "org.springframework"      % "spring-context"                      % "5.2.2.RELEASE",
  "org.springframework.boot" % "spring-boot-autoconfigure"           % springbootVersion,
  "org.springframework.boot" % "spring-boot-autoconfigure-processor" % springbootVersion,
  "org.hibernate"            % "hibernate-validator"                 % "6.0.16.Final",
  "javax.annotation"         % "javax.annotation-api"                % "1.3.2",
  "io.projectreactor"        % "reactor-core"                        % "3.3.1.RELEASE"   % Optional,
  "org.springframework.boot" % "spring-boot-starter-test"            % springbootVersion % Test,
  "org.junit.platform"       % "junit-platform-launcher"             % "1.4.2"           % Test,
  "org.junit.platform"       % "junit-platform-commons"              % "1.4.2"           % Test,
  "org.junit.jupiter"        % "junit-jupiter-engine"                % "5.4.2"           % Test,
  "org.junit.vintage"        % "junit-vintage-engine"                % "5.4.2"           % Test,
  "net.aichler"              % "jupiter-interface"                   % "0.9.1"           % Test,
  "org.mockito"              % "mockito-core"                        % "2.22.0"          % Test
)

javacOptions in Compile ++= Seq("-source", "8", "-target", "8", "-Xlint:unchecked", "-Xlint:deprecation")

// Skip the javadoc for the moment
sources in (Compile, doc) := Seq.empty
