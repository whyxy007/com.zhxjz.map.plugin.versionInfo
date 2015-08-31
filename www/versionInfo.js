
var versionInfo = {
	getVersionName: function(successCallback,errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'VersionInfoPlugin',
			'getVersionName',
			[]
		);
	},
	getVersionCode: function(successCallback,errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'VersionInfoPlugin',
			'getVersionCode',
			[]
		);
	}
}
module.exports = versionInfo;
