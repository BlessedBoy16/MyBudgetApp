import SwiftUI
import Shared

@main
struct iOSApp: App {
    init() {
        InitKoinIosKt.initKoinIos()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
