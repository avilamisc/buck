/*
 * Copyright 2016-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.io;

public class WatchmanCursor {

  public enum Type {
    TIME_T,
    CLOCK_ID,
    NAMED_CURSOR,
  }

  private String mWatchmanCursor;

  public WatchmanCursor(String initialCursor) {
    this.mWatchmanCursor = initialCursor;
  }

  public void set(String newCursor) {
    mWatchmanCursor = newCursor;
  }

  public String get() {
    return mWatchmanCursor;
  }

  @Override
  public String toString() {
    return mWatchmanCursor;
  }

  public Type getType() {
    if (get().startsWith("n:")) {
      return Type.NAMED_CURSOR;
    } else if (get().startsWith("c:")) {
      return Type.CLOCK_ID;
    } else {
      return Type.TIME_T;
    }
  }
}
