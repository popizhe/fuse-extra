/*
 * Copyright (C) FuseSource, Inc.
 * http://fusesource.com
 *
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

package org.fusesource.fabric.apollo.amqp.protocol.interceptors.common

import org.apache.activemq.apollo.util.Logging
import org.fusesource.fabric.apollo.amqp.codec.interfaces.AMQPFrame
import org.fusesource.fabric.apollo.amqp.protocol.interfaces.Interceptor
import scala.collection.mutable.Queue

/**
 *
 */
class FrameLoggingInterceptor(prefix:String = "") extends Interceptor with Logging {

  override protected def _send(frame:AMQPFrame, tasks:Queue[() => Unit]) = {
    info("%s:send{frame=%s tasks=%s", prefix, frame, tasks)
    outgoing.send(frame, tasks)
  }

  override protected def _receive(frame:AMQPFrame, tasks:Queue[() => Unit]) = {
    info("%s:receive{frame=%s tasks=%s", prefix, frame, tasks)
    incoming.receive(frame, tasks)
  }

}