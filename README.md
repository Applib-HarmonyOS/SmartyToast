Smarty Toast
=================
Introduction
------------
Android library with collection of some smart toasts designs which will help in situations of following:-<br>
<UL>
<LI>Completion of some work(Done!!)</LI>
<LI>Errors</LI>
<LI>Warnings(Done!!)</LI>
<LI>Connection Established(Done!!)</LI>
<LI>Saving completion(Saved!!)</LI>
<LI>Update Status(Updating...)</LI>
</UL>

# Source

The code in this repository was inspired from [amanjeetsingh150/SmartyToast - v1.0](https://github.com/amanjeetsingh150/SmartyToast). We are very thankful to amanjeetsingh150.

# Demo

<img src="https://cloud.githubusercontent.com/assets/12881364/26762716/777f7f70-4964-11e7-870f-4f92e6fabf1e.gif"><br><br>

## Installation

In order to use the library, add the following line to your **root** gradle file:

I) For using SmartyToast module in sample app, include the source code and add the below
 dependencies in entry/build.gradle to generate hap/support.har.
```
dependencies {
        implementation project(path: ':smartytoast')
        implementation fileTree(dir: 'libs', include: ['*.har'])
        testImplementation 'junit:junit:4.13'
}
```
II) For using SmartyToast in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.
```
dependencies {
        implementation fileTree(dir: 'libs', include: ['*.har'])
        testImplementation 'junit:junit:4.12'
}
```

Usage
-----
I). Invoke makeText method of SmartyToast class. Set the type parameter to display the custom
 toast as required.

	SmartyToast smartyToast = new SmartyToast(getApplicationContext());
	smartyToast.makeText("Your Message!!", SmartyToast.LENGTH_SHORT, SmartyToast.DONE);


License
-------
	Copyright 2017 Amanjeet Singh
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
	
	http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
