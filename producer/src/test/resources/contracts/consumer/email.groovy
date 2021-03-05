import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label("trigger")
    input {
        triggeredBy("trigger()")
    }
    outputMessage {
        sentTo("asyncRequests")
        body([
                sender: anyEmail(),
                receiver: anyEmail(),
                body: optional(alphaNumeric()),
                body: optional(alphaNumeric())
        ])
    }
}