package ua.nure.nikolaienko

import org.springframework.stereotype.Component

/**
 * Created by vlad on 05.06.16.
 */
@Component
class GitLoader {

    def clone(String url, String login, String password) {
        def command = formatCommand(login, password, url)
        def executor = command.execute()
        if (executor.exitValue() != 0) {
            throw new GitCloneException()
        }
    }


    private String formatCommand(String login, String password, String url) {
        def sb = 'git clone https://'
        if (login != null) {
            sb += ':' + password + '@'
        }
        sb += +'github.com/' + login + '/' + url + '.git'
        sb
    }
}
