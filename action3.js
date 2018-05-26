function main(args) {
	var msg = "you didn&#39;t tell me who you are."
		if (args.name) {
			msg = `hello ${args.name}!`
		}
		return {
		body:
		`<html><body><h3><center>${msg}</center></h3></body></html>`
	}
}
