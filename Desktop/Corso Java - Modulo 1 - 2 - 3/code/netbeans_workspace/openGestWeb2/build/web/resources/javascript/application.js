
function confirmDelete() {
	return confirm("Eliminare l'elemento selezionato?");
}

function confirmLink() {
	return confirm("Sei sicuro di voler proseguire?");
}

function confirmAction(actionUrl) {
	if (confirm("Sei sicuro di voler proseguire?")) {
		window.location=actionUrl;
	}
}