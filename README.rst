==================
README for f3ktime
==================

This is f3k timesend webservice prototype

Installing
==========

Install from newest version from github::

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


More about F3K/DLG
==================

You can read them online at <https://en.wikipedia.org/wiki/Discus_Launch_Glider>.


Authors and contact info
========================

Victor Selukov <victor.selukov@gmail.com>
