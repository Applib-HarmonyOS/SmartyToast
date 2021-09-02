Smarty Toast
=================
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=applibgroup_SmartyToast&metric=alert_status)](https://sonarcloud.io/dashboard?id=applibgroup_SmartyToast)
[![.github/workflows/main.yml](https://github.com/applibgroup/SmartyToast/actions/workflows/main.yml/badge.svg)](https://github.com/applibgroup/SmartyToast/actions/workflows/main.yml)

Introduction
------------
HMOS library with collection of some smart toasts designs which will help in situations of following
:-<br>
<UL>
<LI>Completion of some work(Done!!)</LI>
<LI>Errors</LI>
<LI>Warnings(Done!!)</LI>
<LI>Connection Established(Done!!)</LI>
<LI>Saving completion(Saved!!)</LI>
<LI>Update Status(Updating...)</LI>
</UL>

Source
------------
The code in this repository was inspired from [amanjeetsingh150/SmartyToast - v1.0](https://github.com/amanjeetsingh150/SmartyToast). We are very thankful to amanjeetsingh150.

Screenshot
------------

<img src=/screenshots/smart1.jpg width = "180" height = "400" align=center />  <img src=/screenshots/smart2.jpg width = "180" height = "400" align=center />  <img src=/screenshots/smart3.jpg width = "180" height = "400" align=center /> 

<img src=/screenshots/smart4.jpg width = "180" height = "400" align=center />  <img src=/screenshots/smart5.jpg width = "180" height = "400" align=center />  <img src=/screenshots/smart6.jpg width= "180" height = "400" align=center />


Installation
------------
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
III) For using SmartyToast from a remdropindicatorote repository in separate application, add the
 below dependencies in entry/build.gradle file.
```
dependencies {
        implementation 'dev.applibgroup:smartytoast:1.0.0'
        testCompile 'junit:junit:4.12'
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
