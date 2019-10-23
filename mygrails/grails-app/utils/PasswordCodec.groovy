import java.security.MessageDigest

class PasswordCodec {
    static encode = { str ->
        MessageDigest md = MessageDigest.getInstance('SHA')
        md.update(str.getBytes('UTF-8'))
        return (Base64.getEncoder().encodeToString(md.digest()))
    }
}