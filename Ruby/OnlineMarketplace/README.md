# Online Marketplace Service

## Description
A simple server using Ruby on Rails and GraphQL that supports simple APIs

## How to run

1. Make sure you have ruby, rails, SQLite3, and bundler on your system. Start your ruby server

```bash
$ ruby -v
$ sqlite3 --version
$ gem install bundler
$ gem install rails
$ bundle install
$ rails db:create
$ rails s
```

If the first line doesn't show a ruby version of 2.5.x, please update your ruby since this has only been tested on 2.5.x ruby (to be precise,  2.5.3 is the version I have tested on).

If the second line doesn't show a SQLite3 version of 3.x (I used 3.26.0 to be precise), please make sure you have up to date SQLite3 in your system set up.

The 3-5 lines are for you to install bundler, rails, and stuff in gemfile once you have ruby.

The second last line is for you to create your own testing database.

The last line should start the rails server for you. Go to whichever port that it ends up running on, but most likely localhost:3000

I tested everything on Windows, lmk if there are any mac-unique bugs. To troubleshoot, try to look into the guide [here](https://www.howtographql.com/graphql-ruby/1-getting-started/)

2.
