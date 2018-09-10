==================
README for f3ktime
==================

This is f3k timesend webservice prototype

Installing
==========

Install the newest version from github::

   git clone https://github.com/wws22/f3ktime.git

Briefing
========

The main purpose contain in develop the universal interface between
stopwatch and score counting program during F3K aeromodelling contests.

.. class:: no-web

    .. image:: https://raw.githubusercontent.com/wws22/f3ktime/master/docs/WS_sequence_diagram.png
        :alt: F3K timesend WS sequence diagram
        :width: 100%
        :align: center


The project includes:
=====================

Sample of WSDL::

   docs/f3ktime.wsdl

XSD for datatypes::

   docs/f3ktime.xsd

Samples of SOAP interaction::

   docs/Samples.txt

The Example of server side code::

   src/timesend/f3k.java

This code can try with SOAP UI <https://www.soapui.org/>

NB!
===

It's very important to use equal values for PORT & PATH by compatibility reasons.

The best practice contain is in use DNS Service Discovery (DNS-SD) like a Zeroconf, Bonjour, mDNS-SD <http://www.dns-sd.org>.
That make possible to find the f3ktime-server automatically from smartphone or any other device in your LAN.

We has tried to use Zeroconf library <https://github.com/faceless2/cu-zeroconf> and has been very satisfied.

It was looked like:

.. code-block:: java

    Zeroconf zeroconf = new Zeroconf();
    zeroconf.addAllNetworkInterfaces();
    Service s = zeroconf.newService("f3ktime", "http", 6543).putText("path", "/services/timesend/f3k");
    s.announce();
    /*
     Place your WS here :
     Object implementor = new f3k();
     String endpoint = getWsEndpoint();
     Endpoint.publish(endpoint, implementor);
     ...
    */
    s.cancel();
    zeroconf.close();

Where:

.. code-block:: java

    PORT = 6543
    PATH = /services/timesend/f3k
    SERVICE = f3ktime

We has used the own fixed version of cu-zeroconf.  For install from github enter::

    git clone https://github.com/wws22/cu-zeroconf
    git checkout fixes

Servers & Clients
=================

* F3KScore (server) -  Java program for managing contests <http://olgol.com/F3KScore/>
* F3K Stopwatch (client) - Android stopwatch <https://play.google.com/store/apps/details?id=com.VictorasLT.StopWatch>

More about F3K/DLG
==================

You can read them online at <https://en.wikipedia.org/wiki/Discus_Launch_Glider>.


Authors and contact info
========================

Victor Selukov <victor [dot] selukov [at] gmail.com>
