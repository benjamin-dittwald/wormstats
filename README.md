# WormStats README
WormStats is a simple webbased leage system for worms like games.

# Get Started

## Prerequisites
1. Install git
1. Install Sun Java JDK >= 6
1. Install Maven >= 2

## Get the source
1. `git clone git://github.com/einzeller/wormstats.git`

## Build Project
1. Edit $PROJECT_DIR/src/wormstats/persistence-ejb/src/main/resources/META-INF/persistence.xml and change the value of *eclipselink.ddl-generation* to *create-tables*
1. Run `$PROJECT_DIR/src/wormstats/wormstats-ear/mvn install`

## PostgreSQL
1. Download and install PostgreSQL >= 8.4
1. Create a user and database for WormStats

## GlassFish & deploy
1. Download and install [GlassFish AS](http://glassfish.java.net/) >= 3.1
1. Download [PostgreSQL JDBC Driver](http://jdbc.postgresql.org/download.html) according to yout PostgreSQL version and copy it to your GlassFish installation lib directory
1. Start Glassfish
1. Configure a PostgreSQL Connection Pool for the created user and database
1. Create a jdbc resource for the connection pool and name it *jdbc/wormstats*
1. Deploy $PROJECT_DIR/src/wormstats/wormstats-ear/target/wormstats-ear-1.0-SNAPSHOT.ear

## PostgreSQL #2
1. Insert $PROJECT_DIR/scripts/qoutes.sql dump into the created wormstats database

## Run the application
1. Open your preferred webbrowser and go to [http://localhost:8080/wormstats-web](http://localhost:8080/wormstats-web)

# Contact
Benjamin Dittwald, bendittwald at googlemail.com

