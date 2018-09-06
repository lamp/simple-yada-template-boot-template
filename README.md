# simple-yada-template

A Boot Template template for [Yada](https://github.com/juxt/yada).

## Usage

```sh
boot -d boot/new new -t simple-yada-template -n myapp
```

This will generate you an app at `pwd/myapp` and at `myapp/src/myapp` you will find:

- core.clj
- build.boot
- .gitignore
- config.edn

## Generated Tasks

- `boot run` Run a development server

## TODO:
- Add boot repl task
- Get repl port from task-options not webserver config
- Add compilation tasks

## License

Copyright © 2017 @lamp

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
