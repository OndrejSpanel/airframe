/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package wvlet.airframe.spec

import wvlet.airframe.surface.MethodSurface

/**
  * An interface for compatibility between Scala JVM and Scala.js
  */
private[spec] trait CompatApi {
  private[spec] def isScalaJs: Boolean

  private[spec] def findCompanionObjectOf(fullyQualifiedName: String, classLoader: ClassLoader): Option[Any]
  private[spec] def newInstanceOf(fullyQualifiedName: String, classLoader: ClassLoader): Option[Any]
  private[spec] def withLogScanner[U](block: => U): U
  private[spec] def findCause(e: Throwable): Throwable

  private[spec] def methodSurfacesOf(cls: Class[_]): Seq[MethodSurface]
}
