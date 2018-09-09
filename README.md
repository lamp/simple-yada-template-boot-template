# simple-yada-template

A Boot Template template for [Yada](https://github.com/juxt/yada).

The idea is to provide just enough to get startred with a minimal web app, avoiding adding too many
libraries that are often deleted in these generators.

## Usage

```sh
boot -d boot/new new -t simple-yada-template -n myapp
```

This will generate you an app at `pwd/myapp` and inside `pwd/myapp` you will find:

- src/myapp/core.clj
- build.boot
- .gitignore
- config.edn

## Generated Tasks

- `boot run` Run a development server (You will also find an nrepl server running on port 5600)

## TODO:
- [ ] Add boot repl task
- [ ] Add cider middleware injections
- [ ] Get repl port from task-options not webserver config (no idea why I thought that was a good idea)
- [ ] Add compilation tasks
- [ ] Add test task
- [ ] Add test config to generated app

## License

Copyright © 2017 @lamp

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
