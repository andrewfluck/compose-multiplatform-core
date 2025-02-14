/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.privacysandbox.tools.apigenerator

import java.io.File
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CallbacksApiGeneratorTest : BaseApiGeneratorTest() {
    override val inputDirectory = File("src/test/test-data/callbacks/input")
    override val outputDirectory = File("src/test/test-data/callbacks/output")
    override val relativePathsToExpectedAidlClasses = listOf(
        "com/sdkwithcallbacks/IMyInterface.java",
        "com/sdkwithcallbacks/ISdkCallback.java",
        "com/sdkwithcallbacks/ISdkService.java",
        "com/sdkwithcallbacks/ParcelableResponse.java",
    )
}