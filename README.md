# SolidMQ

<p>SolidMQ is an IoT application that logs all data transfer between clients. 
SolidMQ can also display this data.</p>

####Installation:
Build from source or download jar in releases

####Running:
**SolidMQ has only been tested on linux, running on different systems might result in unexpected effects**   
Run SolidMQ by executing the .jar executable with no arguments. This will create a folder in ~/SolidMQ containing the log files.


####Usage:
    solidmq
    solidmq -h
    solidmq -g -t <topic>
    solidmq -c <setting> <value>
    solidmq -r <date YYYY-MM-DD> [topic]
   

####Structure:
The file structure is as follows:

Take the topic <code>/home/livingroom/</code> and <code>/home/bathroom</code> with clients light1, light2 and display, light1, tempsensor.

<ul>
    <li>SolidMQ
    <ul>
        <li>livingroom
            <ul>
                <li>light1</li>
                <li>light2</li>
            </ul>
        </li>
        <li>bathroom
            <ul>
                <li>display</li>
                <li>light1</li>
                <li>tempsensor</li>
            </ul>
        </li>
    </ul>
    </li>
</ul>

Where SolidMQ directory is places in your home directory <code>~</code>.

You can configure the main directory by running

